import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { AppComponent } from './app.component';
import {routing} from "./app.routing";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./services/user.service";
import {LocationsService} from "./services/locations.service";
import {ProductService} from "./services/product.service";
import {SurveyService} from "./services/survey.service";
import {SurveyQuestionsService} from "./services/survey-questions.service";
import {SurveyAnswersService} from "./services/survey-answers.service";
import {UserLocationService} from "./services/user-location.service";
import { UserComponent } from './user/user.component';
import { LocationsComponent } from './locations/locations.component';
import { ProductComponent } from './product/product.component';
import { SurveyComponent } from './survey/survey.component';
import { SurveyAnswersComponent } from './survey-answers/survey-answers.component';
import { SurveyQuestionsComponent } from './survey-questions/survey-questions.component';
import { UserLocationComponent } from './user-location/user-location.component';
import { UserListComponent } from './user-list/user-list.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LocationsComponent,
    ProductComponent,	
    SurveyComponent,
    SurveyAnswersComponent,
    SurveyQuestionsComponent,
    UserLocationComponent,
    UserListComponent,
    HomeComponent	
  ],
  imports: [
    BrowserModule,
	routing,
	FormsModule,
	ReactiveFormsModule,
	HttpClientModule
  ],
  providers: [
    UserService,
	LocationsService,
	ProductService,
	SurveyService,
	SurveyQuestionsService,
	SurveyAnswersService,
	UserLocationService
	],
  bootstrap: [AppComponent]
})
export class AppModule { }
