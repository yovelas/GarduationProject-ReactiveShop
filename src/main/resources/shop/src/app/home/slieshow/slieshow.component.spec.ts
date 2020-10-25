import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SlieshowComponent } from './slieshow.component';

describe('SlieshowComponent', () => {
  let component: SlieshowComponent;
  let fixture: ComponentFixture<SlieshowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SlieshowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SlieshowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
