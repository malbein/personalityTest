import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../question/question.service";
import {QuestionModel} from "../question/question.model";

@Component({
  selector: 'test-main',
  styleUrls: ['test.component.less'],
  templateUrl: 'test.component.html',
  providers: [QuestionService]
})
export class TestComponent implements OnInit {
  questions: QuestionModel[] = [];

  constructor(private questionService: QuestionService) {
  }

  ngOnInit(): void {
    this.refreshData();
  }

  private refreshData() {
    this.questionService.getAll().subscribe(questions => {
      if (questions) {
        this.questions = questions;
      }
    });
  }
}
