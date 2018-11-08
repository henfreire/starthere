import {create} from 'apisauce';

const api = create({
  baseURL: 'http://localhost:8000',
  headers: {Accept: 'application/json'}
});

export default api;
