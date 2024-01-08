import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipPutComponent } from './ship-put.component';

describe('ShipPutComponent', () => {
  let component: ShipPutComponent;
  let fixture: ComponentFixture<ShipPutComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ShipPutComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ShipPutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
