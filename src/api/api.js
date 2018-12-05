import {create} from 'apisauce';

const api = create({
  baseURL: 'http://127.0.0.1:7202',
  headers: {'Accept': 'application/json, text/javascript, */*; q=0.01'}
});

export default api;
