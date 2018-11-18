import {create} from 'apisauce';

const api = create({
  baseURL: 'http://127.0.0.1:7201',
  headers: {'Accept': 'application/json'}
});

export default api;
