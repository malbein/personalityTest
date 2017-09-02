import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import {AnswerModel} from "./model/answer.model";

@Injectable()
export class AnswerService {

  constructor(private http: HttpClient) {
  }

  public post(request: AnswerModel): Observable<AnswerModel>{
    let url = environment.endPoints.answer.post;
    return this.http.post(url,request).map((res:Response) => {
      return res;
    })
      .catch(err => {
        return Observable.of(null);
      });
  }
}
