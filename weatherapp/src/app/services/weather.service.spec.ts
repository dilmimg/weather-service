import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { WeatherService } from './weather.service';

describe('WeatherService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    imports: [HttpClientTestingModule],
  }));

  function setup() {
    const weatherService = TestBed.get(WeatherService);
    const httpTestingController = TestBed.get(HttpTestingController);
    return { weatherService, httpTestingController };
  }

  it('should be created', () => {
    const { weatherService } = setup();
    expect(weatherService).toBeTruthy();
  });

  it('should fetch weather details', () => {
    const { weatherService, httpTestingController } = setup();
    const mockWeatherDetails = {'cities': [
        {'name': 'Melbourne', 'temperature': '15'},
        {'name': 'Sydney', 'temperature': '24'}]};
      weatherService.getWeatherDetails().subscribe(res => {
      expect(res).toEqual(mockWeatherDetails);
    });

    const mockUrl = '/temperature/city';
    const req = httpTestingController.expectOne(r => r.url.includes(mockUrl));

    expect(req.request.method).toBe('GET');

    req.flush(mockWeatherDetails);
  });

  afterEach(() => {
    const { httpTestingController } = setup();
    httpTestingController.verify();
  });
});

