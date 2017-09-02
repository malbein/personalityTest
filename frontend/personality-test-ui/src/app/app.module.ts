import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { TestComponent } from "./test/test.component";

import { AlertModule } from 'ngx-bootstrap';
import {SingleChoice} from "./question/single-choice/single-choice.component";
import {SingleChoiceConditional} from "./question/single-choice-conditional/single-choice-conditional.component";

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    SingleChoice,
    SingleChoiceConditional
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AlertModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
