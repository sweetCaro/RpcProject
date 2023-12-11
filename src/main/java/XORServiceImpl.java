import io.grpc.stub.StreamObserver;

public class XORServiceImpl extends XORServiceGrpc.XORServiceImplBase {
    @Override
    public void calculateXOR(XORRequest request, StreamObserver<XORResponse> responseObserver) {
        int result = request.getNum1() ^ request.getNum2();
        XORResponse response = XORResponse.newBuilder().setResult(result).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
