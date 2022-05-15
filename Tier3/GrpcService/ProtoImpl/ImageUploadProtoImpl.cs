using Google.Protobuf;
using Grpc.Core;

namespace GRPCService.ProtoImpl;

public class ImageUploadProtoImpl:image.imageBase
{
    public override async Task<FileUploadResponse> Upload(IAsyncStreamReader<FileUploadRequest> requestStream,
        ServerCallContext context) {
        // FileUploadRequest uploadRequest = requestStream.Current;
        // ByteString byteString = uploadRequest.File.Content;
        // throw new NotImplementedException();
        await requestStream.MoveNext();

        string fileName = requestStream.Current.Metadata.Name;
        string fileType = requestStream.Current.Metadata.Type;
        string fileNameToSave = $"{fileName}.{fileType}";
        Console.WriteLine("Writing image :" + fileName);
        byte[] byteFirst = Array.Empty<byte>();
        while (await requestStream.MoveNext()) {
            ByteString fileContent = requestStream.Current.File.Content;
            byte[] byteArray = fileContent.ToByteArray();
            byteFirst = Combine(byteFirst, byteArray);
        }


        bool boolean = ByteArrayToFile(fileNameToSave, byteFirst);
        if (!boolean) {
            return new FileUploadResponse() {
                Name = "",
                Status = UploadStatus.Failed
            };
        }

        return new FileUploadResponse() {
            Name = "",
            Status = UploadStatus.Success
        };
    }


    private bool ByteArrayToFile(string fileName, byte[] byteArray) {
        try {
            using (var fs = new FileStream(fileName, FileMode.Create, FileAccess.Write)) {
                fs.Write(byteArray, 0, byteArray.Length);
                return true;
            }
        }
        catch (Exception ex) {
            Console.WriteLine("Exception caught in process: {0}", ex);
            return false;
        }
    }

    private byte[] Combine(byte[] first, byte[] second) {
        byte[] ret = new byte[first.Length + second.Length];
        Buffer.BlockCopy(first, 0, ret, 0, first.Length);
        Buffer.BlockCopy(second, 0, ret, first.Length, second.Length);
        return ret;
    }
}