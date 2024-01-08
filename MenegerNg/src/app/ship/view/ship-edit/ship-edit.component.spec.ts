import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipEditComponent } from './ship-edit.component';

describe('CharacterEditComponent', () => {
  let component: ShipEditComponent;
  let fixture: ComponentFixture<ShipEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShipEditComponent]
    });
    fixture = TestBed.createComponent(ShipEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
