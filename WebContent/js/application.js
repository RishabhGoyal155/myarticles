(function($){
  $(function(){
    $('.multiselect').multiSelect();
    $('#multipleHeaders').multiSelect({
      selectableHeader : '<h4>Selectable Items</h4>',
      selectedHeader : '<h4>Selected Items</h4>'
    });
    
    $('#callbackCountries').multiSelect({
      afterSelect: function(value, text){
        alert('Select element\nvalue: '+value+'\ntext: '+text);
      },
      afterDeselect: function(value, text){
        alert('Deselect element\nvalue: '+value+'\ntext: '+text);
      }
    });

    $('#selectAll').click(function(){
      $('#outsideCountries').multiSelect('select_all');
      return false;
    });
    
    $('#deselectAll').click(function(){
      $('#outsideCountries').multiSelect('deselect_all');
      return false;
    });

    $('#selectFR').click(function(){
      $('#outsideCountries').multiSelect('select', 'fr');
      return false;
    });
    
    $('#deselectFR').click(function(){
      $('#outsideCountries').multiSelect('deselect', 'fr');
      return false;
    });
    
    $('#demos-menu li').click(function(){
      $('#demos-menu li').removeClass('active');
      $('#demos-content').children('div').hide();
      $(this).addClass('active');
      $('#demos-content .'+$(this).attr('id')).show();
    });
  });
})(jQuery)