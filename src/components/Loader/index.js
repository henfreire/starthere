import React from 'react';
import ContentLoader from 'react-content-loader';

const LoaderTabela = (props) => (
	<ContentLoader rtl height={30} width={800} speed={2} primaryColor="#f3f3f3" secondaryColor="#ecebeb" {...props}>
		<rect x="16.63" y="11.56" rx="0" ry="0" width="18.21" height="16.99" />
		<rect x="70.78" y="15.41" rx="0" ry="0" width="92.4" height="6.77" />
		<rect x="201.52" y="14.67" rx="0" ry="0" width="114.08" height="6.77" />
		<rect x="344.28" y="12.67" rx="0" ry="0" width="88.98" height="6.77" />
		<rect x="463.52" y="11.56" rx="0" ry="0" width="81" height="6.77" />
	</ContentLoader>
);
export { LoaderTabela };
