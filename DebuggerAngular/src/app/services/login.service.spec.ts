import { TestBed } from '@angular/core/testing';

import { LoginService } from './login.service';

describe('LoginService', () => {
  let service: LoginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LoginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should check new user - Positive Test', () => {
    expect(service.checkNewUser('swastika.fmri@fmr.com', 'SWASTIKA12')).toBe(false);
  });

  it('should check new user - Negative Test', () => {
    expect(service.checkNewUser('Vishwanath@fmr.com', 'xyz')).toBe(true);
  });

  it('should verify user with password - Positive Test', () => {
    expect(service.verifyUser('swastika.fmri@fmr.com', 'SWASTIKA12')).toBe(true);
  });

  //Wrong Password given
  it('should verify user with wrong password - Negative Test', () => {
    expect(service.verifyUser('swastika.fmri@fmr.com', 'SWASTIKA1000')).toBe(false);
  });

});
