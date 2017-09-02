import {QuestionTypeModel} from "./question-type.model";

export class QuestionModel {
  public id: number;
  public question: string;
  public category: string;

  public question_type: QuestionTypeModel;
}

