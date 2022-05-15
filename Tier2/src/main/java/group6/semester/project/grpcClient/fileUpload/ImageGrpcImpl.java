package group6.semester.project.grpcClient.fileUpload;

import GRPCService.Image;
import GRPCService.imageGrpc;
import com.google.protobuf.ByteString;
import group6.semester.project.grpcClient.ManagedChannelGetter;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImageGrpcImpl
{

  private imageGrpc.imageStub imageStub;
  private StreamObserver<Image.FileUploadRequest> streamObserver = getImageStub().upload(new FileUploadObserver());
  Path path = Paths.get("src/main/java/group6/semester/project/grpcClient/fileUpload/testImage.png");


  private imageGrpc.imageStub getImageStub() {
    if (imageStub == null) {
      ManagedChannel managedChannel = ManagedChannelGetter.getManagedChannel();
      imageStub = imageGrpc.newStub(managedChannel);
    }
    return imageStub;

  }


  public void uploadImage() throws IOException {

    // build metadata
    Image.FileUploadRequest metadata = Image.FileUploadRequest.newBuilder().setMetadata(
        Image.MetaData.newBuilder().setName("test").setType("png").build()
    ).build();
    streamObserver.onNext(metadata);


    // upload file as a chunk
    InputStream inputStream = Files.newInputStream(path);
    byte[] bytes = new byte[4096];
    int size;
    while ((size = inputStream.read(bytes)) > 0) {
      Image.FileUploadRequest uploadRequest = Image.FileUploadRequest.newBuilder()
          .setFile(Image.FileObj.newBuilder().setContent(ByteString.copyFrom(bytes,0,size)).build()).build();
      streamObserver.onNext(uploadRequest);
    }
    // close the stream
    inputStream.close();
    streamObserver.onCompleted();
  }
  private class FileUploadObserver implements StreamObserver<Image.FileUploadResponse>
  {
    @Override
    public void onNext(Image.FileUploadResponse fileUploadResponse) {
      System.out.println("File upload status ::"+fileUploadResponse.getStatus());
    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onCompleted() {

    }
  }
}

