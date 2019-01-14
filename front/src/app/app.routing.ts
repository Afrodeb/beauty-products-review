import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user/user.component';
import { LocationsComponent } from './locations/locations.component';
import { ProductComponent } from './product/product.component';
import { SurveyComponent } from './survey/survey.component';
import { SurveyAnswersComponent } from './survey-answers/survey-answers.component';
import { SurveyQuestionsComponent } from './survey-questions/survey-questions.component';
import { UserLocationComponent } from './user-location/user-location.component';
import { UserListComponent } from './user-list/user-list.component';

const routes: Routes = [
  { path: 'user', component: UserComponent },
  { path: 'users', component: UserListComponent },
  { path: 'user-location', component: LocationsComponent },
  { path: 'product', component: ProductComponent },
  { path: 'survey', component: SurveyComponent },
  { path: 'survey-answers', component: SurveyAnswersComponent },
  { path: 'survey-questions', component: SurveyQuestionsComponent },
  { path: 'user-location', component: UserLocationComponent }
  ];

export const routing = RouterModule.forRoot(routes);