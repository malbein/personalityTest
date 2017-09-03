import {Component, Input, OnInit} from "@angular/core";
import {QuestionModel} from "../model/question.model";
import {AnswerModel} from "../model/answer.model";
import {AnswerService} from "../answer.service";

@Component({
  selector: 'single-choice-conditional',
  styleUrls: ['single-choice-conditional.component.less'],
  templateUrl: 'single-choice-conditional.component.html',
  providers: [AnswerService]
})
export class SingleChoiceConditional implements OnInit{

  answer: AnswerModel;
  @Input() question: QuestionModel;
  @Input() user: string;
  @Input() categorystyle: string;
  show_conditional: boolean = false;

  constructor(private answerService: AnswerService) {
  }

  public submitAnswer(value){
    this.answer.answer = value;
    this.answerService.post(this.answer).subscribe();
    if(value == this.question.question_type.condition.predicate.exactEquals[1]){
      this.show_conditional = true;
    }else{
      this.show_conditional = false;
    }
  }

  ngOnInit(){
    if (!this.answer) {
      this.answer = new AnswerModel();
    }
    this.answer.question = this.question.id;
    this.answer.user = this.user;
  }

}
