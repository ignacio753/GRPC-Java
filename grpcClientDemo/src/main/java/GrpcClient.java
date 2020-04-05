import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import tech.ignacio.grpc.User.*;
import tech.ignacio.grpc.userGrpc.*;
import tech.ignacio.grpc.userGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",9090).usePlaintext().build();

        userBlockingStub userStub = userGrpc.newBlockingStub(channel);
        LoginRequest request = LoginRequest.newBuilder().setUsername("test").setPassword("asdf").build();

        APIResponse response = userStub.login(request);

        System.out.println(response.getResponseMessage());

    }
}
