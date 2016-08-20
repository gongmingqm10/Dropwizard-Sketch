var fs = require('fs');
var path = require('path');
var gulp = require('gulp');
var browserify = require('browserify');
var babelify = require('babelify');
var source = require('vinyl-source-stream');
var uglify = require('gulp-uglify');
var gutil = require('gulp-util');
var sourcemaps = require('gulp-sourcemaps');
var buffer = require('vinyl-buffer');
var scss = require('gulp-sass');
var autoprefixer = require('gulp-autoprefixer');
var karma = require('karma');
var jshint = require('gulp-jshint');

function buildJs() {
    return browserify({debug: false})
        .transform(babelify)
        .add('src/main/javascript/main.js')
        .bundle()
        .pipe(source('main.js'))
        .pipe(buffer())
        .pipe(sourcemaps.init({loadMaps: true}))
        .pipe(uglify())
        .on('error', gutil.log)
        .pipe(sourcemaps.write('../maps'))
        .pipe(gulp.dest('src/main/resources/assets/javascript/'))
        .pipe(gulp.dest('build/resources/main/assets/javascript/'));
}

function buildScss() {
    return gulp.src('src/main/scss/**/*.scss')
        .pipe(scss({
            outputStyle: 'compressed', sourcemap: true,
            includePaths: ['node_modules/']
        }))
        .pipe(sourcemaps.init({loadMaps: true}))
        .pipe(scss.sync().on('error', scss.logError))
        .pipe(autoprefixer({browsers: ['> 5%', 'last 2 versions']}))
        .pipe(sourcemaps.write('../maps'))
        .pipe(gulp.dest('src/main/resources/assets/styles/'))
        .pipe(gulp.dest('build/resources/main/assets/styles/'));
}

function moveMustacheTemplates() {
    return gulp.src('src/main/resources/**/*.mustache')
        .pipe(gulp.dest('build/resources/main'))
}

gulp.task('build-js', buildJs);
gulp.task('build-scss', buildScss);
gulp.task('move-mustache-templates', moveMustacheTemplates);
gulp.task('default', ['build']);
gulp.task('build', ['build-js', 'build-scss']);

gulp.task('watch', ['default'], function () {
    gulp.watch(['src/main/javascript/**/*.js'], ['build-js']);
    gulp.watch(['src/main/scss/**/*.scss'], ['build-scss']);
    gulp.watch(['src/main/resources/**/*.mustache'], ['move-mustache-templates']);
});
