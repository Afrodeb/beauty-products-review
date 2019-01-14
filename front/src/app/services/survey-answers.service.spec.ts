import { TestBed } from '@angular/core/testing';

import { SurveyAnswersService } from './survey-answers.service';

describe('SurveyAnswersService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SurveyAnswersService = TestBed.get(SurveyAnswersService);
    expect(service).toBeTruthy();
  });
});
