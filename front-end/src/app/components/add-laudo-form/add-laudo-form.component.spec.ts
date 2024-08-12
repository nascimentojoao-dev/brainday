import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLaudoFormComponent } from './add-laudo-form.component';

describe('AddLaudoFormComponent', () => {
  let component: AddLaudoFormComponent;
  let fixture: ComponentFixture<AddLaudoFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddLaudoFormComponent]
    });
    fixture = TestBed.createComponent(AddLaudoFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
