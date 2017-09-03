import { TestBed, async } from '@angular/core/testing';
import {BrowserModule} from "@angular/platform-browser";
import {HttpClientModule} from "@angular/common/http";
import {AlertModule} from "ngx-bootstrap";
import {AppComponent} from "../../app.component";
import {TestComponent} from "../../test/test.component";
import {SingleChoice} from "../single-choice/single-choice.component";
import {SingleChoiceConditional} from "./single-choice-conditional.component";
import {NumberRange} from "../number-range/number-range.component";

describe('SingleChoiceConditional', () => {
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
    const fixture = TestBed.createComponent(SingleChoiceConditional);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it(`should not been show_conditional`, async(() => {
    const fixture = TestBed.createComponent(SingleChoiceConditional);
    const app = fixture.debugElement.componentInstance;
    expect(app.show_conditional).toEqual(false);
  }));

});
