import {Component, Input, OnInit} from "@angular/core";
import {QuestionModel} from "../model/question.model";
import {AnswerModel} from "../model/answer.model";
import {AnswerService} from "../answer.service";

@Component({
  selector: 'single-choice',
  styleUrls: ['single-choice.component.less'],
  templateUrl: 'single-choice.component.html',
  providers: [AnswerService]
})
export class SingleChoice implements OnInit{

  answer: AnswerModel;
  @Input() question: QuestionModel;

  constructor(private answerService: AnswerService) {
  }

  public submitAnswer(value){
    this.answer.answer = value;
    this.answerService.post(this.answer).subscribe();
  }

  ngOnInit(){
    if (!this.answer) {
      this.answer = new AnswerModel();
    }
    this.answer.question = this.question.id;
  }

}
