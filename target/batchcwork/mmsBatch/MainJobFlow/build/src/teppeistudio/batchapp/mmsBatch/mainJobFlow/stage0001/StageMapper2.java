package teppeistudio.batchapp.mmsBatch.mainJobFlow.stage0001;
import com.asakusafw.runtime.flow.MapperWithRuntimeResource;
import com.asakusafw.runtime.trace.TraceLocation;
import java.io.IOException;
import org.apache.hadoop.io.NullWritable;
import teppeistudio.modelgen.dmdl.model.ModelB;
/**
 * {@code [in->extend(operator#1741587908){owner=FlowBlock&#64;1792263773}]}の処理を担当するマッププログラム。
 */
@TraceLocation(batchId = "mmsBatch", flowId = "MainJobFlow", stageId = "stage0001", stageUnitId = "m2")@SuppressWarnings
        ("deprecation") public final class StageMapper2 extends MapperWithRuntimeResource<NullWritable, ModelB, 
        ShuffleKey, ShuffleValue> {
    private ModelB cache = new ModelB();
    private MapFragment2 line;
    @Override public void setup(Context context) throws IOException, InterruptedException {
        final MapOutputFragment2 shuffle0 = new MapOutputFragment2(context);
        this.line = new MapFragment2(shuffle0);
    }
    @Override public void cleanup(Context context) throws IOException, InterruptedException {
        this.line = null;
    }
    @Override public void runInternal(Context context) throws IOException, InterruptedException {
        this.setup(context);
        while(context.nextKeyValue()) {
            cache.copyFrom(context.getCurrentValue());
            this.line.add(cache);
        }
        this.cleanup(context);
    }
}