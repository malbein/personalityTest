import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { QuestionModel } from '../question/question.model'
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable()
export class QuestionService {

  constructor(private http: HttpClient) {
  }

  public getAll(): Observable<QuestionModel[]>{
    let url = environment.endPoints.question.list;
    return this.http.get(url).map((res:Response) => {
      let questions = res;
      return questions;
    })
    .catch(err => {
      return Observable.of(null);
    });
  }
}
