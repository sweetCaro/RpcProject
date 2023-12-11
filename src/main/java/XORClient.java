import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class XORClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        XORServiceGrpc.XORServiceBlockingStub stub = XORServiceGrpc.newBlockingStub(channel);

        XORRequest request = XORRequest.newBuilder().setNum1(10).setNum2(5).build();
        XORResponse response = stub.calculateXOR(request);

        System.out.println("gRPC XOR Result: " + response.getResult());

        channel.shutdown();
    }
}
