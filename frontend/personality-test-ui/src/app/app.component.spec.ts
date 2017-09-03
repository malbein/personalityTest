import { TestBed, async } from '@angular/core/testing';

import { AppComponent } from './app.component';
import {TestComponent} from "./test/test.component";
import {SingleChoice} from "./question/single-choice/single-choice.component";
import {SingleChoiceConditional} from "./question/single-choice-conditional/single-choice-conditional.component";
import {NumberRange} from "./question/number-range/number-range.component";
import {BrowserModule} from "@angular/platform-browser";
import {AlertModule} from "ngx-bootstrap";
import {HttpClientModule} from "@angular/common/http";

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        TestComponent,
        SingleChoice,
        SingleChoiceConditional,
        NumberRange
      ],
      imports: [
        BrowserModule,
        HttpClientModule,
        AlertModule.forRoot()
      ],
      providers: [],
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'app'`, async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('app');
  }));

  it('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Personality Test');
  }));
});
