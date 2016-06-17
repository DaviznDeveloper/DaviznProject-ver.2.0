/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.inlinesave = {
		postUrl: '/myurl',
		postData: {test: true},
		onSave: function(editor) { console.log('clicked save', editor); return true; },
		onSuccess: function(editor, data) { console.log('save successful', editor, data); },
		onFailure: function(editor, status, request) { console.log('save failed', editor, status, request); },
		useJSON: false,
		useColorIcon: false
	};
	config.filebrowserImageUploadUrl = '/resources/upload/upload-drag-drop';
    config.filebrowserUploadUrl = '/resources/upload/upload-drag-drop';
	config.autosaveTargetUrl = 'http://example.com/path_to_script_that_saves_data';
	
	config.font_names = '돋움; Nanum Gothic Coding; 맑은 고딕; 바탕; 궁서; Quattrocento Sans;' +  
	    CKEDITOR.config.font_names;
};
