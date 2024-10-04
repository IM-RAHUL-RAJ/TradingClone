import { TestBed } from '@angular/core/testing';

import { RoboAdvisorServiceService } from './robo-advisor-service.service';

describe('RoboAdvisorServiceService', () => {
  let service: RoboAdvisorServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RoboAdvisorServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
