import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TradeComponent } from './trade.component';

describe('TradeComponent', () => {
  let component: TradeComponent;
  let fixture: ComponentFixture<TradeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TradeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TradeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should contain Buy Button', () => { 
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('table tr td button.buy')?.textContent).toContain('Buy');
  });

  it('should contain Sell Button', () => { 
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('table tr td button.sell')?.textContent).toContain('Sell');
  });
});
