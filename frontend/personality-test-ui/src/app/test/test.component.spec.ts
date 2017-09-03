import { TestBed, async } from '@angular/core/testing';
import {AppComponent} from "../app.component";
import {TestComponent} from "./test.component";
import {SingleChoice} from "../question/single-choice/single-choice.component";
import {SingleChoiceConditional} from "../question/single-choice-conditional/single-choice-conditional.component";
import {NumberRange} from "../question/number-range/number-range.component";
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {AlertModule} from "ngx-bootstrap";

describe('TestComponent', () => {
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
    const fixture = TestBed.createComponent(TestComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should not been registered`, async(() => {
    const fixture = TestBed.createComponent(TestComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.registered).toEqual(false);
  }));

  it(`should not been finished`, async(() => {
    const fixture = TestBed.createComponent(TestComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.finish).toEqual(false);
  }));
});
