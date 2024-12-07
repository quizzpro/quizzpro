import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponsablerhDashboardComponent } from './responsablerh-dashboard.component';

describe('ResponsablerhDashboardComponent', () => {
  let component: ResponsablerhDashboardComponent;
  let fixture: ComponentFixture<ResponsablerhDashboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResponsablerhDashboardComponent]
    });
    fixture = TestBed.createComponent(ResponsablerhDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
