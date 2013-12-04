package teppeistudio.batchapp.mmsBatch.mainJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.ArrayListBuffer;
import com.asakusafw.runtime.trace.TraceLocation;
import teppeistudio.modelgen.dmdl.model.ModelAb;
import teppeistudio.operator.MainOperatorImpl;
/**
 * {@code [listA->MainOperator.m2mJoined(operator#1721906704), listB->MainOperator.m2mJoined(operator#1721906704)]}
         * の処理を担当するマッププログラムの断片。
 */
@TraceLocation(batchId = "mmsBatch", flowId = "MainJobFlow", stageId = "stage0001", fragmentId = "3")@SuppressWarnings(
        "deprecation") public final class ReduceFragment3 extends com.asakusafw.runtime.flow.Rendezvous<ShuffleValue> {
    private final Result<ModelAb> listAB;
    private ArrayListBuffer<ModelAb> list = new ArrayListBuffer<ModelAb>();
    private ArrayListBuffer<ModelAb> list0 = new ArrayListBuffer<ModelAb>();
    private MainOperatorImpl op = new MainOperatorImpl();
    /**
     * インスタンスを生成する。
     * @param listAB {@code MainOperator.m2mJoined#listAB}への出力
     */
    public ReduceFragment3(Result<ModelAb> listAB) {
        this.listAB = listAB;
    }
    @Override public void process(ShuffleValue value) {
        switch(value.getSegmentId()) {
            case 1:
                this.process0001(value.getPort1());
                break;
            case 2:
                this.process0002(value.getPort2());
                break;
            default:
                throw new AssertionError(value);
        }
    }
    @Override public void begin() {
        this.list.begin();
        this.list0.begin();
    }
    @Override public void end() {
        this.list.end();
        this.list0.end();
        this.op.m2mJoined(this.list, this.list0, this.listAB);
        this.list.shrink();
        this.list0.shrink();
    }
    private void process0001(ModelAb value) {
        if(this.list.isExpandRequired()) {
            this.list.expand(new ModelAb());
            this.list.advance().copyFrom(value);
        }
        else {
            this.list.advance().copyFrom(value);
        }
    }
    private void process0002(ModelAb value) {
        if(this.list0.isExpandRequired()) {
            this.list0.expand(new ModelAb());
            this.list0.advance().copyFrom(value);
        }
        else {
            this.list0.advance().copyFrom(value);
        }
    }
}