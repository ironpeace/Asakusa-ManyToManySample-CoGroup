package teppeistudio.operator;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.vocabulary.flow.Operator;
import com.asakusafw.vocabulary.flow.Source;
import com.asakusafw.vocabulary.flow.graph.FlowBoundary;
import com.asakusafw.vocabulary.flow.graph.FlowElementResolver;
import com.asakusafw.vocabulary.flow.graph.ObservationCount;
import com.asakusafw.vocabulary.flow.graph.OperatorDescription;
import com.asakusafw.vocabulary.flow.graph.ShuffleKey;
import com.asakusafw.vocabulary.flow.processor.InputBuffer;
import com.asakusafw.vocabulary.operator.CoGroup;
import com.asakusafw.vocabulary.operator.KeyInfo;
import com.asakusafw.vocabulary.operator.OperatorFactory;
import com.asakusafw.vocabulary.operator.OperatorInfo;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import teppeistudio.modelgen.dmdl.model.ModelAb;
/**
 * {@link MainOperator}に関する演算子ファクトリークラス。
 * @see MainOperator
 */
@Generated("OperatorFactoryClassGenerator:0.0.1")@OperatorFactory(MainOperator.class) public class MainOperatorFactory {
    /**
     */
    public static final class M2mJoined implements Operator {
        private final FlowElementResolver $;
        /**
         */
        public final Source<ModelAb> listAB;
        M2mJoined(Source<ModelAb> listA, Source<ModelAb> listB) {
            OperatorDescription.Builder builder = new OperatorDescription.Builder(CoGroup.class);
            builder.declare(MainOperator.class, MainOperatorImpl.class, "m2mJoined");
            builder.declareParameter(List.class);
            builder.declareParameter(List.class);
            builder.declareParameter(Result.class);
            builder.addInput("listA", listA, new ShuffleKey(Arrays.asList(new String[]{"id"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addInput("listB", listB, new ShuffleKey(Arrays.asList(new String[]{"id"}), Arrays.asList(new 
                    ShuffleKey.Order[]{})));
            builder.addOutput("listAB", ModelAb.class);
            builder.addAttribute(FlowBoundary.SHUFFLE);
            builder.addAttribute(ObservationCount.DONT_CARE);
            builder.addAttribute(InputBuffer.EXPAND);
            this.$ = builder.toResolver();
            this.$.resolveInput("listA", listA);
            this.$.resolveInput("listB", listB);
            this.listAB = this.$.resolveOutput("listAB");
        }
        /**
         * この演算子の名前を設定する。
         * @param newName 設定する名前
         * @return この演算子オブジェクト (this)
         * @throws IllegalArgumentException 引数に{@code null}が指定された場合
         */
        public MainOperatorFactory.M2mJoined as(String newName) {
            this.$.setName(newName);
            return this;
        }
    }
    /**
     * @param listA
     * @param listB
     * @return 生成した演算子オブジェクト
     * @see MainOperator#m2mJoined(List, List, Result)
     */
    @OperatorInfo(kind = CoGroup.class, input = {@OperatorInfo.Input(name = "listA", type = ModelAb.class, position = 0)
                ,@OperatorInfo.Input(name = "listB", type = ModelAb.class, position = 1)}, output = {@OperatorInfo.
                Output(name = "listAB", type = ModelAb.class)}, parameter = {}) public MainOperatorFactory.M2mJoined 
            m2mJoined(@KeyInfo(group = {@KeyInfo.Group(expression = "id")}, order = {}) Source<ModelAb> listA,@KeyInfo(
            group = {@KeyInfo.Group(expression = "id")}, order = {}) Source<ModelAb> listB) {
        return new MainOperatorFactory.M2mJoined(listA, listB);
    }
}