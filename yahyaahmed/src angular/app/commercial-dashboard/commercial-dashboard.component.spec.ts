import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CommercialDashboardComponent } from './commercial-dashboard.component';

describe('CommercialDashboardComponent', () => {
  let component: CommercialDashboardComponent;
  let fixture: ComponentFixture<CommercialDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CommercialDashboardComponent]
    });
    fixture = TestBed.createComponent(CommercialDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
