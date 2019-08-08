import { async, ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';

import { CityTemperatureComponent } from './city-temperature.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { By } from '@angular/platform-browser';
import { WeatherService } from 'src/app/services/weather.service';
import { Observable, Observer } from 'rxjs';

describe('CityTemperatureComponent', () => {
  let component: CityTemperatureComponent;
  let fixture: ComponentFixture<CityTemperatureComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      declarations: [ CityTemperatureComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CityTemperatureComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should render title in a h1 tag', () => {
    fixture = TestBed.createComponent(CityTemperatureComponent);
    fixture.detectChanges();
    const element = fixture.debugElement.nativeElement;
    expect(element.querySelector('h1').textContent).toContain('Weather Service');
  });

  it('should render weather details', fakeAsync(() => {
    const asyncWeatherService = fixture.debugElement.injector.get(WeatherService);
    const mockWeatherDetails = {'cities': [
      {'name': 'Melbourne', 'temperature': '15'},
      {'name': 'Sydney', 'temperature': '24'}]};

    spyOn(asyncWeatherService, 'getWeatherDetails').and.returnValue(
      Observable.create((observer: Observer<{ cities: {name: string, temperature: string}[]}>) => {
        observer.next(mockWeatherDetails);
        return observer;
      })
    );

    tick();

    component.ngOnInit();
    fixture.detectChanges();
    expect(component.cityTemperatures.length).toEqual(2);

    const tableRows = fixture.nativeElement.querySelectorAll('tr');
    expect(tableRows).toBeTruthy();
    expect(tableRows.length).toBe(3);
  }));

  it('should display error message when weather details is undefined', fakeAsync(() => {
    const asyncWeatherService = fixture.debugElement.injector.get(WeatherService);
    const mockWeatherDetails = undefined;

    spyOn(asyncWeatherService, 'getWeatherDetails').and.returnValue(
      Observable.create((observer: Observer<{ cities: {name: string, temperature: string}[]}>) => {
        observer.next(mockWeatherDetails);
        return observer;
      })
    );

    tick();

    component.ngOnInit();
    fixture.detectChanges();
    expect(component.cityTemperatures).toBeUndefined();

    const element = fixture.debugElement.query(By.css('.alert.alert-warning')).nativeElement;
    expect(element.textContent).toEqual('Weather service is unavailable now. Please try again later.');
  }));
});
