import {Injectable} from "@angular/core";
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";
import { environment } from '../../environments/environment';

@Injectable()
export class CategoryService {

  constructor(private http: HttpClient) {

  }

  public getAll(): Observable<string[]>{
    let url = environment.endPoints.category.list;
    return this.http.get(url).map((res:Response) => {
      return res;
    })
      .catch(err => {
        return Observable.of(null);
      });
  }

}
