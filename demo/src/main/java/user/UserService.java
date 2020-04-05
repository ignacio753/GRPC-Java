package user;


import io.grpc.stub.StreamObserver;
import tech.ignacio.grpc.User.*;
import tech.ignacio.grpc.userGrpc.userImplBase;

public class UserService extends userImplBase {
    @Override
    public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
        System.out.println("Inside login");

        String username = request.getUsername();
        String password = request.getPassword();

        APIResponse.Builder response = APIResponse.newBuilder();
        if(username.equals(password)) {
            response.setResponseCode(0).setResponseMessage("SUCCESS");
        } else {
            response.setResponseCode(100).setResponseMessage("INVALID RESPONSE");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {

    }
}
