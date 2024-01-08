import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FleetPutComponent } from './fleet-put.component';

describe('FleetPutComponent', () => {
  let component: FleetPutComponent;
  let fixture: ComponentFixture<FleetPutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FleetPutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FleetPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
