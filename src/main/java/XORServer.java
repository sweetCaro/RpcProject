import io.grpc.Server;
import io.grpc.ServerBuilder;

public class XORServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new XORServiceImpl())
                .build();

        System.out.println("Starting XOR gRPC server...");
        server.start();
        server.awaitTermination();
    }
}
