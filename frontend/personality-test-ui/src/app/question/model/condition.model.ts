import {QuestionModel} from "./question.model";
import {ConditionPredicateModel} from "./condition.predicate.model";

export class ConditionModel {
  public id:number;
  public if_positive:QuestionModel;
  public predicate:ConditionPredicateModel;
}
