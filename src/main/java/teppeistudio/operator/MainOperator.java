package teppeistudio.operator;

import java.util.List;
import teppeistudio.modelgen.dmdl.model.ModelAb;
import com.asakusafw.runtime.core.Result;
import com.asakusafw.vocabulary.model.Key;
import com.asakusafw.vocabulary.operator.CoGroup;

public abstract class MainOperator {

	@CoGroup
	public void m2mJoined(
			@Key(group="id") List<ModelAb> listA,
			@Key(group="id") List<ModelAb> listB,
			Result<ModelAb> listAB
			){
		
		ModelAb ab = new ModelAb();
		
		//ModelAもModelBも該当キーのレコードがある場合
		if(listA.size() == 1 && listB.size() == 1){
			ab.setId(listA.get(0).getId());
			ab.setName(listA.get(0).getName());
			ab.setDataA(listA.get(0).getDataA());
			ab.setDataB(listB.get(0).getDataB());
			
		//ModelAだけ該当キーのレコードがある場合
		}else if(listA.size() != 0 && listB.size() == 0){
			ab.copyFrom(listA.get(0));

		//ModelBだけ該当キーのレコードがある場合
		}else if(listA.size() == 0 && listB.size() != 0){
			ab.copyFrom(listB.get(0));
			
		//ModelAもModelBも該当キーが無い場合、あるいはどちらかが２件以上ある場合
		}else{
			throw new Error("ここには来ないはず");
		}
		
		listAB.add(ab);
	}
}
