import {Component, OnInit} from '@angular/core';
import {QuestionService} from "../question/question.service";
import {QuestionModel} from "../question/model/question.model";
import {register} from "ts-node/dist";
import {CategoryService} from "../util/category.service";

@Component({
  selector: 'test-main',
  styleUrls: ['test.component.less'],
  templateUrl: 'test.component.html',
  providers: [QuestionService, CategoryService]
})
export class TestComponent implements OnInit {
  questions: QuestionModel[] = [];
  finish: boolean = false;
  registered: boolean = false;
  private user = '';
  categories: string[] = [];

  constructor(private questionService: QuestionService,
              private categoryService: CategoryService) {
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
    this.categoryService.getAll().subscribe(categories => {
      if (categories) {
        this.categories = categories;
      }
    });

  }

  onKey(event: any) {
    this.user = event.target.value;
  }

  startTest(){
    this.registered = true;
  }

  endTest(){
    this.finish = true;
  }

  public getCategoryStyle(category): string{
    let index = this.categories.indexOf(category)
    let style;
    if(index == 0){
      return "panel-primary";
    }
    if(index == 1){
      return "panel-success";
    }
    if(index == 2){
      return "panel-info";
    }
    if(index == 3){
      return "panel-warning";
    }
    if(index == 4){
      return "panel-danger";
    }
    return "panel-default";
  }

}
