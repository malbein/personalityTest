import {Component, Input, OnInit} from "@angular/core";
import {QuestionModel} from "../model/question.model";
import {AnswerModel} from "../model/answer.model";
import {AnswerService} from "../answer.service";

@Component({
  selector: 'number-range',
  styleUrls: ['number-range.component.less'],
  templateUrl: 'number-range.component.html',
  providers: [AnswerService]
})
export class NumberRange implements OnInit{

  answer: AnswerModel;
  @Input() question: QuestionModel;
  numbers: Array<number> = [];

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

    let from = this.question.question_type.range.from;
    let to = this.question.question_type.range.to;
    this.numbers = new Array();
    for(var i=from;i<=to;i++) {
      this.numbers.push(i);
    }
  }

}
