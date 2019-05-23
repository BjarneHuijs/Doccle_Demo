import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserOverviewModalPage } from './user-overview-modal.page';

describe('UserOverviewModalPage', () => {
  let component: UserOverviewModalPage;
  let fixture: ComponentFixture<UserOverviewModalPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserOverviewModalPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserOverviewModalPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
