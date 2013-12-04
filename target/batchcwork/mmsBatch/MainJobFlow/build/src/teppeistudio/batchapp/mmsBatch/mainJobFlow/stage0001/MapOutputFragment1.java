package teppeistudio.batchapp.mmsBatch.mainJobFlow.stage0001;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.runtime.flow.ResultOutput;
import org.apache.hadoop.mapreduce.TaskInputOutputContext;
import teppeistudio.modelgen.dmdl.model.ModelAb;
/**
 * {@code listA->MainOperator.m2mJoined(operator#1721906704)}へのシャッフル処理を担当するプログラムの断片。
 */
@SuppressWarnings("deprecation") public final class MapOutputFragment1 implements Result<ModelAb> {
    private final TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector;
    private final ShuffleKey key = new ShuffleKey();
    private final ShuffleValue value = new ShuffleValue();
    /**
     * インスタンスを生成する。
     * @param collector 実際の出力先
     */
    public MapOutputFragment1(TaskInputOutputContext<?, ?, ? super ShuffleKey, ? super ShuffleValue> collector) {
        this.collector = collector;
    }
    @Override public void add(ModelAb result) {
        this.key.setPort1(result);
        this.value.setPort1(result);
        ResultOutput.write(this.collector, this.key, this.value);
    }
}