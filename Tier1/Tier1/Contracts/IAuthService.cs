using System.Security.Claims;

namespace Contracts; 

public interface IAuthService {
    Task LoginAsync(string username, string password);

    Task LogoutAsync();

    Task<ClaimsPrincipal> GetAuthAsync();

    public Action<ClaimsPrincipal> OnAuthStateChanged { get; set; }

}