$(function() {
  $('#searchButton').on('click', function(e) {
    var query = $('#searchCharities').val(),
        $ul = $('.donate-search-result');
    $ul.html('<li>Loading...</li>');
    $.ajax({
      url: '/giving/charities',
      data: { query: query },
      type: 'POST',
      dataType: 'json'
    }).success(function(json) {
      $ul.html('');
      if (json.length == 0) {
        $ul.append($('<li/>').text('No results found for: ' + query));
      } else {
        $.each(json, function(index, charity) {
          var description = charity.description;
          if (description.length > 150) {
            description = description.substr(0, 150) + '...';
          }
          $ul.append($('<li/>')
            .append($('<img/>').attr('style', 'width:125px').attr('src', charity.logoUrl).attr('alt', charity.name))
            .append($('<p/>').text(description))
            .append($('<a/>').addClass('btn btn-success').attr('href', '/giving/form/' + $ul.data('problem-id') + '/' + charity.charityId).addClass('btn btn-success').text('Select'))
            .append($('<div/>').addClass('clearfix')));
        });
      }
    });
  });
});
