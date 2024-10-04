import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  template: '',
})
export class MockNavBarComponent {}

@Component({
  selector: 'app-footer',
  template: '',
})
export class MockFooterComponent {}

@Component({
  selector: 'app-home-page',
  template: '',
})
export class MockHomePageComponent{}

@Component({
  selector: 'app-login',
  template: '',
})
export class MockLoginComponent implements OnInit{
  ngOnInit(){}
}

@Component({
  selector: 'app-signup',
  template: '',
})
export class MockSignupComponent{}

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule
      ],
      declarations: [
        AppComponent,
        MockNavBarComponent,
        MockFooterComponent,
        MockSignupComponent,
        MockLoginComponent,
        MockHomePageComponent
      ],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'debuggers-capstone-project'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('debuggers-capstone-project');
  });

  // it('should render title', () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   const compiled = fixture.nativeElement as HTMLElement;
  //   expect(compiled.querySelector('.content span')?.textContent).toContain('debuggers-capstone-project app is running!');
  // });
});
