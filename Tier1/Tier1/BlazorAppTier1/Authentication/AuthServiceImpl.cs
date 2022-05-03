using System;
using System.Collections.Generic;
using System.Security.Claims;
using System.Text.Json;
using System.Threading.Tasks;
using Contracts;
using Entities.Models;
using HttpServices;
using Microsoft.JSInterop;

namespace BlazorAppTier1.Authentication;

public class AuthServiceImpl : IAuthService {
    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; } = null!;
    private readonly IUserService _userService;
    private readonly IJSRuntime _jsRuntime;
    private ClaimsPrincipal? _principal;

    public AuthServiceImpl(IUserService userService, IJSRuntime jsRuntime) {
        _userService = userService;
        _jsRuntime = jsRuntime;
        _principal = null;
    }

    public async Task LoginAsync(string username, string password) {
        User user = await _userService.GetUserAsync(username);
        //add bycript hashing to verify the login credentials
        bool verified = BCrypt.Net.BCrypt.Verify(password, user.Password);
        //ValidateLoginCredentials(BCrypt.Net.BCrypt.HashPassword(password), user); // Validate input data against data from database
        //ValidateLoginCredentials(password, user);
        
        if (verified)
        {
            await CacheUserAsync(user);
            _principal = CreateClaimsPrincipal(user);
            OnAuthStateChanged?.Invoke(_principal);
        }
    }

    private async Task CacheUserAsync(User? user) {
        string serializedData = JsonSerializer.Serialize(user);
        await _jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", serializedData);
    }

    private ClaimsPrincipal? CreateClaimsPrincipal(User? user) {
        ClaimsIdentity identity = new ClaimsIdentity();
        if (user != null) {
            identity = ConvertUserToClaimsIdentity(user);
        }

        ClaimsPrincipal tempPrincipal = new ClaimsPrincipal(identity);
        return tempPrincipal;
    }

    private ClaimsIdentity ConvertUserToClaimsIdentity(User user) {
        List<Claim> claims = new List<Claim>() {
            new Claim(ClaimTypes.Name, user.Username),
        };
        return new ClaimsIdentity(claims, "apiauth-type");
    }


    public async Task LogoutAsync() {
        await ClearUserFromCacheAsync();
        ClaimsPrincipal principal = CreateClaimsPrincipal(null);
        OnAuthStateChanged?.Invoke(principal);
    }

    private async Task ClearUserFromCacheAsync() {
        await _jsRuntime.InvokeVoidAsync("sessionStorage.setItem", "currentUser", "");
    }

    public async Task<ClaimsPrincipal> GetAuthAsync() {
        if (_principal != null) {
            return _principal;
        }

        string userAsJson = await _jsRuntime.InvokeAsync<string>("sessionStorage.getItem", "currentUser");
        if (string.IsNullOrEmpty(userAsJson)) {
            return new ClaimsPrincipal(new ClaimsIdentity());
        }

        User? user = JsonSerializer.Deserialize<User>(userAsJson);
        user = await _userService.GetUserAsync(user.Username);
        _principal = CreateClaimsPrincipal(user);
        return _principal;
    }

    private void ValidateLoginCredentials(string password, User user) {
        // if (user == null) {
        //     throw new Exception("Username not found");
        // }

        if (!password.Equals(user.Password)) {
            throw new Exception("Password Incorrect");
        }
    }
}