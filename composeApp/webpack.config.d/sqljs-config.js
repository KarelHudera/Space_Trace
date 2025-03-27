// {project}/webpack.config.d/sqljs.js
config.resolve = {
    fallback: {
        fs: false,
        path:false,
        crypto: false,
        os: require.resolve("os-browserify/browser")
    }
};