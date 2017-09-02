import {ConditionModel} from "./condition.model";
import {RangeModel} from "./range.model";

export class QuestionTypeModel {
  public type: number;
  public options: Array<string>;
  public condition: ConditionModel;
  public range: RangeModel;
}
